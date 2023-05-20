import { login, checkSessionExpiration } from '../../events/auth-service.js';

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

export { handleLogin };
