
const content = document.querySelector("#products");

document.querySelector("#category").addEventListener("change", async evt => {
    let selectedCategoryId = evt.target.selectedIndex;
    let selectedCategory = (evt.target[selectedCategoryId].dataset.api);
    let category = await changeItemCategory(selectedCategoryId)
    cardBuilder(category);
} );


document.querySelector("#supplier").addEventListener("change", evt => {
    console.log(evt.target.value);
})

async function changeItemCategory(category){
    const url = `/api/category?category=${category}`;
    return await apiGet(url);
}


function createElement(string){
    return document.createElement(string);
}

function createDiv(string){
    let div = document.createElement("div");
    div.classList.add(string);
    return div;
}

function cardBuilder(news){
    console.log(news)
    content.innerHTML = "";
    for (const entry of news){
        let cardItem = createDiv("card_item");
        let card = createDiv("card_inner");
        let title = createDiv("title");
        let time = createDiv("time_ago");
        let author = createDiv("author");
        let link = createElement("a");
        link.href = entry["url"];
        link.innerText = entry["title"];
        title.append(link);
        time.innerText = entry["time_ago"];
        author.innerText = entry["user"];
        if (author.innerText === "undefined"){
            card.append(title, time);
        } else {
            card.append(title, time, author);
        }
        cardItem.append(card);
        content.append(cardItem);
    }
}

async function apiGet(url){
    let response = await fetch(url);
    if (response.ok){
        console.log(response)
        return response.json();
    }
}

