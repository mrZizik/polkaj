package io.emeraldpay.polkaj.scale.reader

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import org.apache.commons.codec.binary.Hex
import spock.lang.Specification

class ByteReaderSpec extends Specification {

    def "Read positive"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.readByte() == value
        where:
        hex  | value
        "00" | 0
        "7b" | 123
    }

    def "Read negative"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.readByte() == value
        where:
        hex  | value
        "ff" | -1
        "80" | -128
        "81" | -127
        "f1" | -15
    }

}
