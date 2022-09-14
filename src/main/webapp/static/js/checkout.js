const searchBar = document.querySelector("#search-input");
const cartQty = document.querySelector(".cart-qty");

function hideSearchBar() {
    searchBar.parentElement.textContent = '';
    cartQty.parentElement.textContent = '';
}

hideSearchBar();
