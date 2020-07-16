package io.emeraldpay.polkaj.scale.writer;

import java.io.IOException;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;

public class ShortWriter implements ScaleWriter<Short> {
    @Override
    public void write(ScaleCodecWriter wrt, Short value) throws IOException {
        wrt.directWrite(value);
        wrt.directWrite(value >> 8);
    }
}
