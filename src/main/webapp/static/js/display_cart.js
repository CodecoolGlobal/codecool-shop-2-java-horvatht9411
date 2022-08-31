const totalPrice = document.querySelector("#total-price");
const currency = document.querySelector("#currency");
const itemCurrency = document.querySelector(".item-currency");
const priceSum = document.querySelectorAll(".price-sum");
const itemQuantity = document.querySelectorAll(".quantity");

async function apiPost(url, payload) {
    let response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(payload),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (response.ok) {
        return await response.json();
    }
}

async function editQuantity(id, data) {
    return await apiPost(`/api/editCart/${id}`, data)
}

async function editCart() {
    for (let input of itemQuantity) {
        input.addEventListener('input', async (e) => {
                let productId = e.currentTarget.dataset.prodId;
                let quantity = e.currentTarget.value;
                let unitPrice = e.currentTarget.parentNode.parentNode.parentNode.children[2].textContent;
                let itemSum = parseFloat(unitPrice) * parseFloat(quantity);
                e.currentTarget.parentNode.parentNode.parentNode.children[5].textContent = itemSum.toString();
                let total = updateTotalPrice();
                totalPrice.textContent = total.toString();
                await editQuantity(productId, quantity);
            }
        );
    }
}

function updateTotalPrice() {
    const updatedPriceSum = document.querySelectorAll(".price-sum");
    let total = 0;
    for (let price of updatedPriceSum) {
        total += parseFloat(price.textContent);
    }
    totalPrice.textContent = total.toString();
    currency.textContent = ` ${itemCurrency.textContent}`;
    return total;
}

function totalPrices() {
    let total = 0;
    for (let price of priceSum) {
        total += parseFloat(price.textContent);
    }
    totalPrice.textContent = total.toString();
    currency.textContent = ` ${itemCurrency.textContent}`;
}

totalPrices();
editCart();
