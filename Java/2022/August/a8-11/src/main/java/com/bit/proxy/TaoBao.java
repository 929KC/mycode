package com.bit.proxy;

public class TaoBao implements Usb {
   private Usb usbFactory = new UsbFactory();
    @Override
    public float shellUsb() {
        float  price = usbFactory.shellUsb();
        return price+1231;
    }
}
