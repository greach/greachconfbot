package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object contains information about an incoming shipping query.
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery</a>
 */
@Introspected
public class ShippingQuery {
    /**
     * Unique query identifier
     */
    @Nonnull
    @NotBlank
    private String id;

    /**
     * User who sent the query.
     */
    @Nonnull
    @NotNull
    @Valid
    private User from;

    /**
     * Bot specified invoice payload
     */
    @JsonProperty("invoice_payload")
    @Nonnull
    @NotBlank
    private String invoicePayload;

    /**
     * User specified shipping address
     */
    @JsonProperty("shipping_address")
    @Nonnull
    @NotNull
    @Valid
    private ShippingAddress shippingAddress;

    public ShippingQuery() {
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public void setId(@Nonnull String id) {
        this.id = id;
    }

    @Nonnull
    public User getFrom() {
        return from;
    }

    public void setFrom(@Nonnull User from) {
        this.from = from;
    }

    @Nonnull
    public String getInvoicePayload() {
        return invoicePayload;
    }

    public void setInvoicePayload(@Nonnull String invoicePayload) {
        this.invoicePayload = invoicePayload;
    }

    @Nonnull
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(@Nonnull ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "ShippingQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingAddress=" + (shippingAddress != null ? shippingAddress.toString() : "") +
                '}';
    }
}
