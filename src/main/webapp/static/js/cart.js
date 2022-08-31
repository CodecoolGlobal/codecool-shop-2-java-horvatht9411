async function apiGet(url) {
    const response = await fetch(url);
    if (response.ok) {
        console.log(response);
        return response.json();
    }
}

function addToCart() {
    const addButtons = document.querySelectorAll('.add-to-cart');
    const quantityCounter = document.querySelector(".cart-qty");
    for (let addButton of addButtons) {
        addButton.addEventListener("click", async (e) => {
            const id = e.target.dataset.prodId;
            quantityCounter.textContent = await sendProductToCart(id);
        })
    }
}

function sendProductToCart(id){
    const url = `/api/addToCart?id=${id}`;
    return apiGet(url);
}

addToCart();
