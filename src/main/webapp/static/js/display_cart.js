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
        return response.json();
    } else {
        console.log(response.statusText);
    }
}

async function editQuantity(id, data) {
    return await apiPost(`/api/editCart/${id}`, data)
}

async function editCart() {
    for (let input of itemQuantity) {
        input.addEventListener('change', async (e) => {
            let productId = e.currentTarget.dataset.prodId;
            let quantity = parseInt(e.currentTarget.value);
            let unitPrice = e.currentTarget.closest("tr").children[2].textContent;
            let totalByItem = parseFloat(unitPrice) * quantity;
            let itemTotal = e.currentTarget.closest("tr").children[5];
            itemTotal.textContent = totalByItem.toString();
            totalPrice.textContent = updateTotalPrice().toString();
            await editQuantity(productId, quantity);
        });
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

window.onload = async () => {
    totalPrices();
    await editCart();
}
