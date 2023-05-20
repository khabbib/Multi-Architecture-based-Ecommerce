/**
 * Authenticate for login
 * @param {string} email
 * @param {string} password
 */
async function login(email, password) {
	const data = await fetch('http://localhost:8086/auth/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ email, password })
	}).then((res) => res.json());
	if (data.statusCode === 200) {
		localStorage.setItem('expirationTime', String(new Date().getTime() + 20 * 1000));
		localStorage.setItem('user', data.token);
		window.location.href = '/dashboard';
	} else {
		window.location.href = '/login';
	}
}

/**
 * Check if the session has expired
 */
function checkSessionExpiration() {
	const expirationTime = localStorage.getItem('expirationTime');
	const user = localStorage.getItem('user');
	if (expirationTime !== null && user !== null) {
		if (new Date().getTime() > Number(expirationTime)) {
			localStorage.removeItem('expirationTime');
			localStorage.removeItem('user');
			window.location.href = '/login';
		}
	}
}

export { login, checkSessionExpiration };
