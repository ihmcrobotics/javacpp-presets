import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.zed.SL_DeviceProperties;
import org.bytedeco.zed.SL_InitParameters;

import java.nio.charset.StandardCharsets;

import static org.bytedeco.zed.global.zed.*;

public final class ZEDTest {
    public static void main(String[] args) {
        String sdkVersion = sl_get_sdk_version().getString(StandardCharsets.UTF_8);
        System.out.println("ZED SDK version: " + sdkVersion);

        IntPointer deviceCount = new IntPointer(1);
        SL_DeviceProperties devicePropertiesList = new SL_DeviceProperties();

        sl_get_device_list(devicePropertiesList, deviceCount);

        for (int cameraId = 0; cameraId < deviceCount.get(); cameraId++) {
            SL_DeviceProperties deviceProperties = devicePropertiesList.position(cameraId);
            System.out.println("ZED Model: " + deviceProperties.camera_model());
            System.out.println("ZED Serial Number: " + deviceProperties.sn());

            if (!sl_create_camera(cameraId)) {
                System.err.println("Could not create camera ID: " + cameraId);
            }

            SL_InitParameters params = new SL_InitParameters();
            params.camera_fps(30);
            params.resolution(SL_RESOLUTION_HD1080);
            params.input_type(SL_INPUT_TYPE_USB);
            params.camera_device_id(cameraId);
            params.camera_image_flip(SL_FLIP_MODE_AUTO);
            params.camera_disable_self_calib(false);
            params.enable_image_enhancement(true);
            params.svo_real_time_mode(true);
            params.depth_mode(SL_DEPTH_MODE_PERFORMANCE);
            params.depth_stabilization(1);
            params.depth_maximum_distance(40);
            params.depth_minimum_distance(-1);
            params.coordinate_unit(SL_UNIT_METER);
            params.coordinate_system(SL_COORDINATE_SYSTEM_LEFT_HANDED_Y_UP);
            params.sdk_gpu_id(-1);
            params.sdk_verbose(0);
            params.sensors_required(false);
            params.enable_right_side_measure(false);

            int state = sl_open_camera(cameraId, params, 0, "", "", 0, "", "", "");

            if (state != 0) {
                System.err.println("Could not open camera ID: " + cameraId);
                continue;
            }

            sl_close_camera(cameraId);
        }
    }
}