package com.unisoft.algotrader.provider.ib.api.event;

import com.unisoft.algotrader.provider.ib.api.model.data.TickType;

/**
 * Created by alex on 8/26/15.
 */
public class TickOptionComputationEvent  extends IBEvent<TickOptionComputationEvent>  {

    public final TickType type;
    public final double impliedVolatility;
    public final double delta;
    public final double price;
    public final double presentValueDividend;
    public final double gamma;
    public final double vega;
    public final double theta;
    public final double underlyingPrice;

    public TickOptionComputationEvent(final long requestId, final TickType type, final double impliedVolatility,
                                      final double delta, final double price, final double presentValueDividend, final double gamma,
                                      final double vega, final double theta, final double underlyingPrice){
        super(requestId);
        this.type = type;
        this.impliedVolatility = impliedVolatility;
        this.delta = delta;
        this.price = price;
        this.presentValueDividend = presentValueDividend;
        this.gamma = gamma;
        this.vega = vega;
        this.theta = theta;
        this.underlyingPrice = underlyingPrice;
    }

    @Override
    public void on(IBEventHandler handler) {
        handler.onTickOptionComputationEvent(this);
    }

    @Override
    public String toString() {
        return "TickOptionComputationEvent{" +
                "type=" + type +
                ", impliedVolatility=" + impliedVolatility +
                ", delta=" + delta +
                ", price=" + price +
                ", presentValueDividend=" + presentValueDividend +
                ", gamma=" + gamma +
                ", vega=" + vega +
                ", theta=" + theta +
                ", underlyingPrice=" + underlyingPrice +
                "} " + super.toString();
    }
}