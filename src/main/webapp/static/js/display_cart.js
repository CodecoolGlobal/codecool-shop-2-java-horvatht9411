const totalPrice = document.querySelector("#total-price");
const priceSum = document.querySelectorAll(".price-sum");
const itemQuantity = document.querySelectorAll(".quantity");
const deleteButton = document.querySelectorAll(".delete-item");
const tableBody = document.querySelector("tbody");

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

async function apiDelete(url) {
    let response = await fetch(url, {
        method: "DELETE",
    });
    if (response.ok) {
        return await response.json();
    }
}

async function editQuantity(id, data) {
    return await apiPost(`/api/editCart/${id}`, data);
}

async function deleteItem(id) {
    return await apiDelete(`/api/removeFromCart/${id}`);
}

async function editCart() {
    for (let input of itemQuantity) {
        input.addEventListener('change', async (e) => {
            let productId = e.currentTarget.dataset.prodId;
            let quantity = parseInt(e.currentTarget.value);
            let totals = await editQuantity(productId, quantity);
            let itemTotal = e.target.closest("tr").children[4];
            itemTotal.textContent = totals[0] + " HUF";
            totalPrice.textContent = totals[1];
        });
    }
}

async function deleteItemFromCart() {
    for (let button of deleteButton) {
        button.addEventListener('click', async (e) => {
            let productId = e.currentTarget.dataset.itemId;
            let itemRow = e.currentTarget.closest("tr");
            tableBody.removeChild(itemRow);
            totalPrice.textContent = await deleteItem(productId);
        });
    }
}

function totalPrices() {
    let total = 0;
    for (let price of priceSum) {
        total += parseInt(price.textContent);
    }
    totalPrice.textContent = total.toString();
}

window.onload = async () => {
    totalPrices();
    await editCart();
    await deleteItemFromCart();
}


