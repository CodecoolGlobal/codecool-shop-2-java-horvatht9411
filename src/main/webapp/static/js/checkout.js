const searchBar = document.querySelector("#search-input");

function hideSearchBar() {
    searchBar.parentElement.textContent = '';
    cartQty.parentElement.textContent = '';
}

window.onload = async () => {
    hideSearchBar();
}