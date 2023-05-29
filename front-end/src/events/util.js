import { navigateTo } from './navigator';

async function checkAuthInLoginPage() {
	// Check if user is authenticated
	const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
	if (token) {
		console.log('token: ', token);
		await fetch('http://localhost:8080/auth/check', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ token })
		}).then((res) => {
			console.log('check Response in login page: ', res);
			if (res.status === 200) {
				console.log('User is still logged in');
				navigateTo('dashboard', null);
			} else {
				localStorage.removeItem('sessionToken');
			}
		});
	}
}

async function checkAuthInDashboardPage() {
	console.log('Check auth in dashboard page');
	// Check if user is authenticated
	const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
	if (token) {
		// Authenticate the user
		await fetch('http://localhost:8080/auth/check', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ token })
		})
			.then((res) => {
				console.log('check Response: ', res);
				if (res.status === 200) {
					console.log('User is still logged in');
				} else {
					localStorage.removeItem('sessionToken');
					navigateTo('login', "You're not logged in");
				}
			})
			.catch((err) => {
				console.error('Dashboard Authentication failed: ', err);
			});
	} else {
		navigateTo('login', "You're not logged in");
	}
}

async function getOnlineUsers() {
	try {
		const response = await fetch('http://localhost:8080/auth/online', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const users = await response.json();
			return users;
		} else {
			throw new Error('Failed to get online users');
		}
	} catch (error) {
		console.error('Error retrieving online users:', error);
		return [];
	}
}

async function createUser(name, email, password) {
	if(name === "" || email === "" || password === ""){
		return makeErrorMessage("Name, email or password cannot be empty");
	}

	if(!email.includes("@")){
		return makeErrorMessage("Email is not valid");
	}

	if(password.length < 6){
		return makeErrorMessage("Password must be at least 6 characters long");
	}

	try {
		await fetch('http://localhost:8080/users/create', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ name, email, password })
		}).then((res) => {
			if (res.status === 200) {
				navigateTo('login', 'User created successfully');
				// Add a function to give information to user
			}
		});
	} catch (error) {
		console.log('Error creating user:', error);
	}
}

async function handleLogout() {
	localStorage.removeItem('sessionToken'); // Clear the token from cookie or local storage
	navigateTo('login', 'You have been logged out');
}

async function validateLogin(email, password){
	if(email === "" || password === ""){
		return makeErrorMessage("Email or password cannot be empty");
	}

	if(!email.includes("@")){
		return makeErrorMessage("Email is not valid");
	}

	try {
		const response = await fetch('http://localhost:8080/auth/login', {
			method: 'POST',
			body: JSON.stringify({ email, password }),
			headers: {
				'Content-Type': 'application/json'
			},
			credentials: 'include' // Enable sending cookies with cross-origin requests
		}).then((res) => res.json());
		if (response.length > 0 && response[0].cookie) {
			window.localStorage.setItem('sessionToken', response[0].cookie);
			navigateTo('dashboard', "Successfully logged in");
		} else {
			const error = {
				status: 'error',
				error: 'Email or password is incorrect'
			};
			return error;
		}
	} catch (er) {
		const  error = {
			status: 'error',
			error: 'Something went wrong, please try again later'
		}
		return error;
	}

}


function makeErrorMessage(error) {
	return {
		status: 'error',
		error
	};
}


async function getAllProducts() {
	try {
		const response = await fetch('http://localhost:8080/products/', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const products = await response.json();
			return products;
		} else {
			console.log('Error');
		}
	} catch (error) {
		console.error('Error retrieving products:', error);
		return [];
	}
}

async function getSearchedProduct(query) {
  if(query === '') return [];
	try {
		const response = await fetch('http://localhost:8080/search/' + query, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});

		if (response.ok) {
			const search = await response.json();
			return search;
		} else {
			console.log('Error');
			return [];
		}
	} catch (error) {
		console.error('Error retrieving search:', error);
		return [];
	}
}

export {
	checkAuthInLoginPage,
	checkAuthInDashboardPage,
	handleLogout,
	validateLogin,
	getOnlineUsers,
	getAllProducts,
	getSearchedProduct,
	createUser,
};
