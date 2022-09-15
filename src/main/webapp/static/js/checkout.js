const searchBar = document.querySelector("#search-input");
const cartQty = document.querySelector(".cart-qty");
const login = document.querySelector("#login");
const register = document.querySelector("#register");

function hideSearchBar() {
    searchBar.parentElement.textContent = '';
    cartQty.parentElement.textContent = '';
    login.style.display = "none";
    register.style.display = "none";
}

hideSearchBar();
