package io.emeraldpay.polkaj.scale.reader

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import org.apache.commons.codec.binary.Hex
import spock.lang.Specification

class LongReaderSpec extends Specification {

    LongReader reader = new LongReader()

    def "Read positive"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.read(reader) == value
        where:
        hex   | value
        "0102030405060708"| 578437695752307201
    }

    def "Read negative"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.read(reader) == value
        where:
        hex    | value
        "ffffffffffffffff"| -1

    }

}
