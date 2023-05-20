

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
        localStorage.setItem('user', data.user);
        localStorage.setItem('token', data.token);
        // Redirect
        window.location.href = '/dashboard';
    } else {
        // Show error message
        document.getElementById('error').innerHTML = data.message;
    }
    
}

/**
 * Check if the session has expired
 */
function checkSessionExpiration() {
    const expirationTime = localStorage.getItem('expirationTime');
    if(expirationTime !== null) {
        if(new Date().getTime() > Number(expirationTime)) {
            // Session has expired, redirect to login page or perform necessary actions
            // Remove session
            localStorage.removeItem('expirationTime');
            window.location.href = '/';
        }
    }

}


export { login, checkSessionExpiration };
