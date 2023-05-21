import { redirect } from "@sveltejs/kit";
import axios from "axios";
import { navigate } from "./navigator";

/**
 * Authenticate for login
 * @param {string} email
 * @param {string} password
 */
async function login(email, password) {
	const credentials = { email, password };
	
	try {
		const response = await axios.post('http://localhost:8086/auth/login', credentials);
		console.log('Login successful', response);
		const { token, expirationTime } = response.data;
		console.log('Login successful', token, expirationTime);
		localStorage.setItem('sessionToken', token);
		localStorage.setItem('expirationTime', expirationTime);
		return true;
		// Store the token in a cookie or local storage
		// navigate('dashboard');
	  } catch (error) {
		  console.error('Login failed', error);
		  return false;
		// Handle login error, display error message to the user, etc.
	  }






	// const data = await fetch('http://localhost:8086/auth/login', {
	// 	method: 'POST',
	// 	headers: {
	// 		'Content-Type': 'application/json'
	// 	},
	// 	body: JSON.stringify({ email, password })
	// }).then((res) => res.json());
	// console.log(data);
	// if (data.statusCode === 200) {
	// 	// localStorage.setItem('expirationTime', String(new Date().getTime() + 20 * 1000));
	// 	// localStorage.setItem('user', data.token);
	// 	return true;
	// }
	// return false;
}

/**
 * Check if the session has expired
 */
function checkSessionExpiration() {
	
	if(localStorage.getItem('expirationTime') === undefined){
		console.log('session expired and return to login');
		return true;
	}
	const expirationTime = localStorage.getItem('expirationTime');
	const user = localStorage.getItem('user');
	if (expirationTime !== null && user !== null) {
		if (new Date().getTime() > Number(expirationTime)) {
			return true;
		}
		return false;
	}
	return true;
}

export { login, checkSessionExpiration };
