const logoutButton = document.querySelector("#logout");

function logout() {
    if (logoutButton != null) {
        logoutButton.addEventListener("click", async () => {
            await apiDelete("/login");
            window.location.href = "/";
        });
    }
}

async function apiDelete(url) {
    let response = await fetch(url, {
        method: "DELETE",
    });
    if (response.ok) {
        return await response.json();
    }
}

window.onload = () => {
    logout();
}