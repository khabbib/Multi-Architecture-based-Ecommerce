/**
 * Set session expiration time
 */
function setSession(user, token) {
	const expirationTime = new Date().getTime() + 20 * 1000;
	localStorage.setItem('expirationTime', String(expirationTime));
	console.log('Session created', expirationTime);
}

export { setSession };
