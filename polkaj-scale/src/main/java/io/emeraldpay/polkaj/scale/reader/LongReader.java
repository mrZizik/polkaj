package io.emeraldpay.polkaj.scale.reader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import io.emeraldpay.polkaj.scale.ScaleCodecReader;
import io.emeraldpay.polkaj.scale.ScaleReader;

public class LongReader implements ScaleReader<Long> {
    @Override
    public Long read(ScaleCodecReader rdr) {
        ByteBuffer buf = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        buf.put(rdr.readByte());
        return ((ByteBuffer) buf.flip()).getLong();
    }
}
