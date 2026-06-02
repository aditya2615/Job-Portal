async function login() {

    const username =
        document.getElementById("username").value;

    const password =
        document.getElementById("password").value;

    const response = await fetch(
        "/api/auth/login",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                username,
                password
            })
        }
    );

    const data = await response.json();

    if(data.role === "RECRUITER"){
        window.location.href =
            "recruiter.html";
    }else{
        window.location.href =
            "candidate.html";
    }
}

async function registerUser(){

    const user = {

        fullName:
            document.getElementById(
                "fullname"
            ).value,

        email:
            document.getElementById(
                "email"
            ).value,

        username:
            document.getElementById(
                "regUsername"
            ).value,

        password:
            document.getElementById(
                "regPassword"
            ).value,

        role:
            document.getElementById(
                "role"
            ).value
    };

    await fetch(
        "/api/auth/register",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(user)
        }
    );

    alert("Registration Successful");

    window.location.href = "index.html";
}
<button onclick="window.location.href='profile.html'">
    My Profile
</button>