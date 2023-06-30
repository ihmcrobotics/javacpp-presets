import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.zed.SL_CommunicationParameters;
import org.bytedeco.zed.SL_InitParameters;
import org.bytedeco.zed.SL_RuntimeParameters;

import static org.bytedeco.zed.global.zed.*;

public class SampleImageCapture
{
   public static void main(String[] args) {
      // Create a ZED camera object
      int camera_id = 0;
      sl_create_camera(camera_id);

      SL_InitParameters init_param = new SL_InitParameters();
      init_param.camera_fps(30);
      init_param.resolution(SL_RESOLUTION_HD1080);
      init_param.input_type(SL_INPUT_TYPE_USB);
      init_param.camera_device_id(camera_id);
      init_param.camera_image_flip(SL_FLIP_MODE_AUTO);
      init_param.camera_disable_self_calib(false);
      init_param.enable_image_enhancement(true);
      init_param.svo_real_time_mode(true);
      init_param.depth_mode(SL_DEPTH_MODE_PERFORMANCE);
      init_param.depth_stabilization(1);
      init_param.depth_maximum_distance(40);
      init_param.depth_minimum_distance(-1);
      init_param.coordinate_unit(SL_UNIT_METER);
      init_param.coordinate_system(SL_COORDINATE_SYSTEM_LEFT_HANDED_Y_UP);
      init_param.sdk_gpu_id(-1);
      init_param.sdk_verbose(0); // false
      init_param.sensors_required(false);
      init_param.enable_right_side_measure(false);
      init_param.open_timeout_sec(5.0f);
      init_param.async_grab_camera_recovery(false);

      // Open the camera
      int state = sl_open_camera(camera_id, init_param, 0, "", "", 0, "", "", "");

      if (state != 0) {
         System.err.println("Error Open");
         System.exit(1);
      }

      SL_RuntimeParameters rt_param = new SL_RuntimeParameters();
      rt_param.enable_depth(true);
      rt_param.confidence_threshold(95);
      rt_param.reference_frame(SL_REFERENCE_FRAME_CAMERA);
      rt_param.texture_confidence_threshold(100);
      rt_param.remove_saturated_areas(true);

      int width = sl_get_width(camera_id);
      int height = sl_get_height(camera_id);

      // Create image pointer
      IntPointer imagePointer = new IntPointer(sl_mat_create_new(width, height, SL_MAT_TYPE_U8_C4, SL_MEM_CPU));

      SL_CommunicationParameters params = new SL_CommunicationParameters();
      params.communication_type(SL_COMM_TYPE_INTRA_PROCESS);
      sl_start_publishing(0, params);

      // Capture 50 frames and stop
      int i = 0;
      while (i < 50) {
         // Gram an image
         state = sl_grab(camera_id, rt_param);
         // A new image is avail if grab() returns ERROR_CODE::SUCCESS
         if (state == 0) {
            // Get the left image
            sl_retrieve_image(camera_id, imagePointer, SL_VIEW_LEFT, SL_MEM_CPU, width, height);

            // Display the image resolution and its acquisition timestamp
            System.out.printf("Image resolution: %d x %d || %d \n", width, height, sl_get_current_timestamp(camera_id));
            i++;
         }
      }

      sl_close_camera(camera_id);
   }
}
