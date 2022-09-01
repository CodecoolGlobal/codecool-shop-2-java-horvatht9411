const content = document.querySelector(".container");

document.querySelector("#category").addEventListener("change", async evt => {
    let selectedCategoryId = evt.target.selectedIndex;
    // let selectedCategory = (evt.target[selectedCategoryId].dataset.api);
    let category = await changeItemCategory(selectedCategoryId);
    cardBuilder(category);
});


document.querySelector("#supplier").addEventListener("change", evt => {
    console.log(evt.target.value);
})

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
    console.log(category);
    content.innerHTML = "";
    for (const cat of category) {
        console.log(cat);
        console.log(cat["id"]);
        console.log(cat[0]);
        let cardItem = createDiv("col");
        let card = createDiv("card");
        let header = createDiv("card-header");
        let title = createElement("h4");
        title.classList.add("card-title");
        title.innerText = cat["name"];
        header.append(title);
        let headerText = createElement("p");
        headerText.classList.add("card-text");
        header.append(headerText);
        let cardText = createDiv("card-text");
        let cardTextParagraph = createElement("p");
        cardTextParagraph.classList.add("lead");
        cardTextParagraph.innerText = cat["defaultPrice"] + cat["defaultCurrency"];
        cardText.append(cardTextParagraph);
        let cardText2 = createDiv("card-text");
        let button = createElement("a");
        button.classList.add("btn");
        button.dataset.prodId = cat["id"];
        button.innerText = "Add to cart";
        cardText2.append(button);

        let cardBody = createDiv("card-body");
        cardBody.append(cardText);
        cardBody.append(cardText2);


        let image = createElement("img");
        image.src = cat["imgURL"];


        card.append(image);
        card.append(header);
        card.append(cardBody);

        cardItem.append(card);
        content.append(cardItem);
    }
}

async function apiGet(url) {
    let response = await fetch(url);
    if (response.ok) {
        console.log(response)
        return response.json();
    }
}

