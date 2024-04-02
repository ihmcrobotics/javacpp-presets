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
                System.err.println(getErrorString(state));
                continue;
            }

            sl_close_camera(cameraId);
        }
    }

    private static String getErrorString(int errorCode) {
        switch (errorCode) {
            case 0:
                return "Success";
            case 1:
                return "Failure";
            case 2:
                return "No GPU compatible";
            case 3:
                return "Not enough GPU memory";
            case 4:
                return "Camera not detected";
            case 5:
                return "Sensors not initialized";
            case 6:
                return "Sensors not available";
            case 7:
                return "Invalid resolution";
            case 8:
                return "Low USB bandwidth";
            case 9:
                return "Calibration file not available";
            case 10:
                return "Invalid calibration file";
            case 11:
                return "Invalid SVO file";
            case 12:
                return "SVO recording error";
            case 13:
                return "SVO unsupported compression";
            case 14:
                return "End of SVO file reached";
            case 15:
                return "Invalid coordinate system";
            case 16:
                return "Invalid firmware";
            case 17:
                return "Invalid function parameters";
            case 18:
                return "CUDA error";
            case 19:
                return "Camera not initialized";
            case 20:
                return "NVIDIA driver out of date";
            case 21:
                return "Invalid function call";
            case 22:
                return "Corrupted SDK installation";
            case 23:
                return "Incompatible SDK version";
            case 24:
                return "Invalid area file";
            case 25:
                return "Incompatible area file";
            case 26:
                return "Camera failed to setup";
            case 27:
                return "Camera detection issue";
            case 28:
                return "Cannot start camera stream";
            case 29:
                return "No GPU detected";
            case 30:
                return "Plane not found";
            case 31:
                return "Module not compatible with camera";
            case 32:
                return "Motion sensors required";
            case 33:
                return "Module not compatible with CUDA version";
        }
        return "Unknown";
    }
}