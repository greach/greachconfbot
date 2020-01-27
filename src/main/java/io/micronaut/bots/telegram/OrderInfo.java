package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nullable;

/**
 * This object represents information about an order.
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo</a>
 */
@Introspected
public class OrderInfo {

    /**
     * User name.
     */
    @Nullable
    private String name;

    /**
     * User's phone number
     */
    @Nullable
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * User email
     */
    @Nullable
    private String email;

    /**
     *  User shipping address
     */
    @Nullable
    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    public OrderInfo() {
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(@Nullable ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", shippingAddress=" + (shippingAddress != null ? shippingAddress.toString() : "") +
                '}';
    }
}
