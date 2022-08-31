const totalPrice = document.querySelector("#total-price");
const currency = document.querySelector("#currency");
const itemCurrency = document.querySelector(".item-currency");
const priceSum = document.querySelectorAll(".price-sum");

function totalPrices() {
    let total = 0;
    for(let price of priceSum){
        total += parseFloat(price.textContent);
    }
    totalPrice.textContent = total.toString();
    currency.textContent = ` ${itemCurrency.textContent}`;
}

totalPrices();

