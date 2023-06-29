import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.zed.SL_CameraInformation;
import org.bytedeco.zed.SL_DeviceProperties;
import org.bytedeco.zed.global.zed;

import java.nio.charset.StandardCharsets;

public final class ZEDTest {

    public static void main(String[] args) {
        String sdkVersion = zed.sl_get_sdk_version().getString(StandardCharsets.UTF_8);
        System.out.println("ZED SDK version: " + sdkVersion);

        IntPointer deviceCount = new IntPointer(1);
        SL_DeviceProperties devicePropertiesList = new SL_DeviceProperties();

        zed.sl_get_device_list(devicePropertiesList, deviceCount);

        for (int i = 0; i < deviceCount.get(); i++) {
            SL_DeviceProperties deviceProperties = devicePropertiesList.position(i);
            SL_CameraInformation cameraInformation = zed.sl_get_camera_information(i, 0, 0);
            System.out.println("ZED Model: " + deviceProperties.camera_model());
            System.out.println("ZED Serial Number: " + deviceProperties.sn());
        }
    }

}
