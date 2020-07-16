package io.emeraldpay.polkaj.scale.writer;

import java.io.IOException;

import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleWriter;

public class LongWriter implements ScaleWriter<Long> {
    @Override
    public void write(ScaleCodecWriter wrt, Long value) throws IOException {
        wrt.directWrite(value.byteValue());
        wrt.directWrite((byte) (value >> 8));
        wrt.directWrite((byte) (value >> 8 * 2));
        wrt.directWrite((byte) (value >> 8 * 3));
        wrt.directWrite((byte) (value >> 8 * 4));
        wrt.directWrite((byte) (value >> 8 * 5));
        wrt.directWrite((byte) (value >> 8 * 6));
        wrt.directWrite((byte) (value >> 8 * 7));
    }
}
