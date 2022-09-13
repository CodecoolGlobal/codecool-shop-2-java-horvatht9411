const categoryMenu = document.querySelectorAll(".filter-category");
const supplierMenu = document.querySelectorAll(".filter-supplier");
const content = document.querySelector("#products");

async function initCategoryMenu() {
    categoryMenu.forEach(category => category.addEventListener("click", async () => {
        let selectedCategoryId = category.dataset.api;
        let selectedCategory = await getSelectedCategory(selectedCategoryId);
        cardBuilder(selectedCategory);
    }));
}

async function getSelectedCategory(category) {
    const url = `/api/category?category=${category}`;
    return await apiGet(url);
}

async function initSupplierMenu() {
    supplierMenu.forEach(supplier => supplier.addEventListener("click", async () => {
        let selectedSupplierId = supplier.dataset.api;
        let selectedSupplier = await getSelectedSupplier(selectedSupplierId);
        cardBuilder(selectedSupplier);
    }));
}

async function getSelectedSupplier(supplier) {
    console.log(supplier)
    const url = `/api/supplier?supplier=${supplier}`;
    return await apiGet(url);
}


function cardBuilder(category) {
    content.innerHTML = "";
    for (const cat of category) {
        let cardItem = createDiv("col");
        addToClassList(cardItem, ["col-sm-12", "col-md-6", "col-lg-4"])
        let card = createDiv("card");
        let header = createDiv("card-header");
        let title = createElement("h4");
        title.innerText = cat["name"];
        addToClassList(title, "card-title");
        let headerText = createElement("p");
        headerText.innerText = cat["description"];
        addToClassList(headerText, ["card-text", "description"]);
        header.append(title);
        header.append(headerText);

        let cardText = createDiv("card-text");
        let cardTextParagraph = createElement("p");
        cardTextParagraph.innerText = cat["defaultPrice"] + " " + cat["defaultCurrency"];
        addToClassList(cardTextParagraph, "lead");
        cardText.append(cardTextParagraph);

        let button = createElement("button");
        button.dataset.prodId = cat["id"];
        button.innerText = "Kosárba";
        addToClassList(button, ["btn", "btn-success", "add-to-cart"])

        let cardText2 = createDiv("card-text");
        cardText2.append(button);

        let cardBody = createDiv("card-body");
        cardBody.append(cardText);
        cardBody.append(cardText2);

        let image = createElement("img");
        image.src = cat["imgURL"];
        addToClassList(image, "prod-image")

        card.append(image);
        card.append(header);
        card.append(cardBody);
        cardItem.append(card);
        content.append(cardItem);
    }
    addToCart();
}

function createElement(string) {
    return document.createElement(string);
}

function createDiv(string) {
    let div = document.createElement("div");
    div.classList.add(string);
    return div;
}

function addToClassList(element, strings) {
    for (const string of strings) {
        element.classList.add(string);
    }
}
