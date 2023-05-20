import { login, checkSessionExpiration } from '../../events/auth-service.js';

/**
 * Set session expiration time
 */
function setSession() {
    const expirationTime = new Date().getTime() + 20 * 1000;
    localStorage.setItem('expirationTime', String(expirationTime));
    console.log('Session created', expirationTime);
}

/**
 * Handle login form submission
 * @param e {Event}
 */
function handleLogin(e) {
    e.preventDefault();
    const form = document.querySelector('form');
    const email = form.email.value;
    const password = form.password.value;
    login(email, password);
}


export {
    setSession,
    handleLogin,
};