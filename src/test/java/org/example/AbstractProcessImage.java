package org.example;

import com.ghgande.j2mod.modbus.procimg.*;

public class AbstractProcessImage implements ProcessImage {

    protected final ProcessImageImplementation image = new SimpleProcessImage();

    @Override
    public DigitalOut[] getDigitalOutRange(final int offset, final int count) throws IllegalAddressException {
        return image.getDigitalOutRange(offset, count);
    }

    @Override
    public DigitalOut getDigitalOut(final int ref) throws IllegalAddressException {
        return image.getDigitalOut(ref);
    }

    @Override
    public int getDigitalOutCount() {
        return image.getDigitalOutCount();
    }

    @Override
    public DigitalIn[] getDigitalInRange(final int offset, final int count) throws IllegalAddressException {
        return image.getDigitalInRange(offset, count);
    }

    @Override
    public DigitalIn getDigitalIn(final int ref) throws IllegalAddressException {
        return image.getDigitalIn(ref);
    }

    @Override
    public int getDigitalInCount() {
        return image.getDigitalInCount();
    }

    @Override
    public InputRegister[] getInputRegisterRange(final int offset, final int count) throws IllegalAddressException {
        return image.getInputRegisterRange(offset, count);
    }

    @Override
    public InputRegister getInputRegister(final int ref) throws IllegalAddressException {
        return image.getInputRegister(ref);
    }

    @Override
    public int getInputRegisterCount() {
        return image.getInputRegisterCount();
    }

    @Override
    public Register[] getRegisterRange(final int offset, final int count) throws IllegalAddressException {
        return image.getRegisterRange(offset, count);
    }

    @Override
    public Register getRegister(final int ref) throws IllegalAddressException {
        return image.getRegister(ref);
    }

    @Override
    public int getRegisterCount() {
        return image.getRegisterCount();
    }

    @Override
    public File getFile(final int ref) throws IllegalAddressException {
        return image.getFile(ref);
    }

    @Override
    public File getFileByNumber(final int ref) throws IllegalAddressException {
        return image.getFileByNumber(ref);
    }

    @Override
    public int getFileCount() {
        return image.getFileCount();
    }

    @Override
    public FIFO getFIFO(final int ref) throws IllegalAddressException {
        return image.getFIFO(ref);
    }

    @Override
    public FIFO getFIFOByAddress(final int ref) throws IllegalAddressException {
        return image.getFIFOByAddress(ref);
    }

    @Override
    public int getFIFOCount() {
        return image.getFIFOCount();
    }
}
