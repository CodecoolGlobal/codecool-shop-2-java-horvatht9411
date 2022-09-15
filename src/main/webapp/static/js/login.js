const loginButton = document.querySelector("#login-button");
const emailField = document.querySelector("#email");
const passwordField = document.querySelector("#password");

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

async function apiGet(url) {
    const response = await fetch(url);
    if (response.ok) {
        return response.json();
    } else {
        console.log(response.statusText);
    }
}

function getFormValues() {
    let email = emailField.value;
    let password = passwordField.value;
    return [email, password];
}

function login() {
    loginButton.addEventListener("click", async () => {
        let dataLoad = getFormValues();
        let validLogin = await apiPost("/login", dataLoad);
        await checkPassword(validLogin);
    })
}

async function checkPassword(validLogin) {
    if (validLogin === "true") {
        window.location.href = "/";
    } else {
        alert("Helytelen bejelentkezés!");
    }
}

window.onload = () => {
    login();
}
