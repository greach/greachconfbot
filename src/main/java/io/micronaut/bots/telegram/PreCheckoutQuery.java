package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @see <a href="https://core.telegram.org/bots/api#precheckoutquery">PreChekoutQuery</a>
 */
@Introspected
public class PreCheckoutQuery {

    /**
     * Unique query identifier
     */
    @Nonnull
    @NotBlank
    private String id;
    /**
     * User who sent the query
     */

    @Nonnull
    @NotNull
    @Valid
    private User from;

    /**
     * Three-letter ISO 4217 currency code
     */
    @Nonnull
    @NotBlank
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @JsonProperty("total_amount")
    @Nonnull
    @NotNull
    private Integer totalAmount;

    /**
     * Bot specified invoice payload
     */
    @JsonProperty("invoice_payload")
    @Nonnull
    @NotBlank
    private String invoicePayload;
    /**
     * Identifier of the shipping option chosen by the user
     */
    @Nullable
    @JsonProperty("shipping_option_id")
    private String shippingOptionId;
    /**
     * Order info provided by the user
     */
    @Nullable
    @Valid
    @JsonProperty("order_info")
    private OrderInfo orderInfo;

    public PreCheckoutQuery() {
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
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(@Nonnull String currency) {
        this.currency = currency;
    }

    @Nonnull
    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(@Nonnull Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Nonnull
    public String getInvoicePayload() {
        return invoicePayload;
    }

    public void setInvoicePayload(@Nonnull String invoicePayload) {
        this.invoicePayload = invoicePayload;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + (orderInfo != null ? orderInfo.toString() : "") +
                '}';
    }
}

