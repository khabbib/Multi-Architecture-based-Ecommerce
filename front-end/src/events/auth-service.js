

// Login handler
async function login(email, password) {
    console.log('login', email, password);
    // Call the backend API for authentication
    // If successful, create a session for the user and redirect the user to dashboard
    // If unsuccessful, redirect the user to the login page with an error message

    const data = await fetch('http://localhost:3000/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    }).then(res => res.json());

    console.log(data);

    if (data.result === 'success') {
        // Session
        sessionStorage.setItem('user', data.user);
        sessionStorage.setItem('token', data.token);
        // Redirect
        window.location.href = '/dashboard';
    } else {
        // Show error message
        document.getElementById('error').innerHTML = data.message;
    }
    
}


export { login };
