

public class SampleDepthSensing
{
   public static void main(String[] args)
   {
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
   }
}