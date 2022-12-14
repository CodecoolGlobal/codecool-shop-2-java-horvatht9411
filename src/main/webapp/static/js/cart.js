const cartQty = document.querySelector(".cart-qty");

function addToCart() {
    const addButtons = document.querySelectorAll('.add-to-cart');
    const quantityCounter = document.querySelector(".cart-qty");
    for (let addButton of addButtons) {
        addButton.addEventListener("click", async (e) => {
            const id = e.target.dataset.prodId;
            quantityCounter.textContent = await sendProductToCart(id, id);
        })
    }
}


function sendProductToCart(id, productId) {
    const url = `/api/editCart/${id}`;
    return apiPost(url, productId);
}

async function updateCartQty() {
    cartQty.textContent = await getCartQuantity();
}

function getCartQuantity() {
    const url = `/api/cartQty`;
    return apiGet(url);
}

async function apiGet(url) {
    const response = await fetch(url);
    if (response.ok) {
        return response.json();
    } else {
        console.log(response.statusText);
    }
}

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





window.onload = async () => {
    await updateCartQty();
    addToCart();
    await initSupplierMenu();
    await initCategoryMenu();
}
