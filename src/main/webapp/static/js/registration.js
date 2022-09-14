const registrationButton = document.querySelector("#reg-button");
const userField = document.querySelector("#username");
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
    let username = userField.value;
    let email = emailField.value;
    let password = passwordField.value;
    return [username, email, password];
}

function register() {
    registrationButton.addEventListener("click", async () => {
        let dataLoad = getFormValues();
        let username = await apiPost("/registration", dataLoad);
        await checkUser(username);
    })
}

async function checkUser(username) {
    let login;
    if (username.length > 0) {
        login = confirm(`Kedves ${username}, Önnek már van regisztrációja.\nKérem, jelentkezzen be!`);
    } else {
        userField.value = "";
        emailField.value = "";
        passwordField.value = "";
        login = confirm("Sikeres regisztráció!\nKérem, jelentkezzen be!");
    }
    if (login) {
        console.log("ez login");
        window.location.href = "/login";
    }
}

window.onload = () => {
    register();
}
