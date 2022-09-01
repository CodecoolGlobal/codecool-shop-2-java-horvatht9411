const categoryMenu = document.querySelectorAll(".filter-category");
const supplierMenu = document.querySelectorAll(".filter-supplier");
const content = document.querySelector("#products");


categoryMenu.forEach(async function (category) {
    category.addEventListener("click", async evt => {
        let selectedCategoryId = category.dataset.api;
        let selectedCategory = await changeItemCategory(selectedCategoryId);
        cardBuilder(selectedCategory);
    });
});


supplierMenu.forEach(async function (supplier) {
    supplier.addEventListener("click", async evt => {
        let selectedSupplierId = supplier.dataset.api;
        let selectedSupplier = await changeItemSupplier(selectedSupplierId);
        cardBuilder(selectedSupplier);
    });
});

async function changeItemSupplier(supplier) {
    const url = `/api/supplier?supplier=${supplier}`;
    return await apiGet(url);
}

async function changeItemCategory(category) {
    const url = `/api/category?category=${category}`;
    return await apiGet(url);
}


function createElement(string) {
    return document.createElement(string);
}

function createDiv(string) {
    let div = document.createElement("div");
    div.classList.add(string);
    return div;
}

function cardBuilder(category) {
    content.innerHTML = "";
    for (const cat of category) {
        let cardItem = createDiv("col");
        cardItem.classList.add("col-sm-12");
        cardItem.classList.add("col-md-6");
        cardItem.classList.add("col-lg-4");
        let card = createDiv("card");
        let header = createDiv("card-header");

        let title = createElement("h4");
        title.classList.add("card-title");
        title.innerText = cat["name"];
        let headerText = createElement("p");
        headerText.classList.add("card-text");
        headerText.classList.add("description");
        headerText.innerText = cat["description"];
        header.append(title);
        header.append(headerText);

        let cardText = createDiv("card-text");
        let cardTextParagraph = createElement("p");
        cardTextParagraph.classList.add("lead");
        cardTextParagraph.innerText = cat["defaultPrice"] + " " + cat["defaultCurrency"];
        cardText.append(cardTextParagraph);

        let button = createElement("button");
        button.dataset.prodId = cat["id"];
        button.classList.add("btn");
        button.classList.add("btn-success");
        button.classList.add("add-to-cart");
        button.innerText = "Add to cart";

        let cardText2 = createDiv("card-text");
        cardText2.append(button);

        let cardBody = createDiv("card-body");
        cardBody.append(cardText);
        cardBody.append(cardText2);


        let image = createElement("img");
        image.src = cat["imgURL"];
        image.classList.add("prod-image");


        card.append(image);
        card.append(header);
        card.append(cardBody);

        cardItem.append(card);
        content.append(cardItem);
    }
    addToCart();
}

async function apiGet(url) {
    let response = await fetch(url);
    if (response.ok) {
        return response.json();
    }
}

