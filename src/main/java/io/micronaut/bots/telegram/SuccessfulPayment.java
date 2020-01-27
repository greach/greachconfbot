package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object contains basic information about a successful payment.
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment</a>
 */
@Introspected
public class SuccessfulPayment {
    /**
     * Three-letter ISO 4217 currency code.
     */
    @Nonnull
    @NotBlank
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @Nonnull
    @NotNull
    @JsonProperty("total_amount")
    private Integer	totalAmount;

    /**
     * Bot specified invoice payload
     */
    @Nonnull
    @NotBlank
    @JsonProperty("invoice_payload")
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
    @JsonProperty("order_info")
    @Valid
    private OrderInfo orderInfo;

    /**
     * Telegram payment identifier
     */
    @Nonnull
    @NotBlank
    @JsonProperty("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    /**
     * Provider payment identifier
     */
    @Nonnull
    @NotBlank
    @JsonProperty("provider_payment_charge_id")
    private String providerPaymentChargeId;

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + (orderInfo != null ? orderInfo.toString() : "") +
                ", telegramPaymentChargeId='" + telegramPaymentChargeId + '\'' +
                ", providerPaymentChargeId='" + providerPaymentChargeId + '\'' +
                '}';
    }
}
