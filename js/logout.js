function formLogout(btnLogout) {

    let url = 'http://localhost:8082/GamePark/rest/user/logout/' + user.id
    fetch(url)
    sessionStorage.removeItem("user")

}

