package com.unisoft.algotrader.provider.ib.api.deserializer;

import com.unisoft.algotrader.provider.ib.api.IBConstants;
import com.unisoft.algotrader.provider.ib.api.IBSession;
import com.unisoft.algotrader.provider.ib.api.IncomingMessageId;
import com.unisoft.algotrader.provider.ib.api.InputStreamUtils;

import java.io.InputStream;

import static com.unisoft.algotrader.provider.ib.api.InputStreamUtils.readString;

/**
 * Created by alex on 8/13/15.
 */
public class TickStringEventDeserializer extends Deserializer {


    public TickStringEventDeserializer(){
        super(IncomingMessageId.TICK_STRING);
    }

    @Override
    public void consumeVersionLess(final int version, final InputStream inputStream, final IBSession ibSession) {
        final int requestId = InputStreamUtils.readInt(inputStream);
        final int tickType = InputStreamUtils.readInt(inputStream);
        final String value = readString(inputStream);
        
        ibSession.onTickStringEvent(requestId, IBConstants.TickType.fromValue(tickType), value);
    }
}