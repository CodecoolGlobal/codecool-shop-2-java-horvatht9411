const searchBar = document.querySelector("#search-input");
const cartQty = document.querySelector(".cart-qty");
const login = document.querySelector("#login")
const register = document.querySelector("#register")

function hideSearchBar() {
    searchBar.parentElement.textContent = '';
    cartQty.parentElement.textContent = '';
    login.textContent = "";
    register.textContent = "";
}

hideSearchBar();
