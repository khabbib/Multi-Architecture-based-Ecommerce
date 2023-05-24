<script>
	import jQuery from 'jquery'; // kör 'npm install jquery' i cmd
    
	const getProducts = async () => {
		console.log("Getting all products...");

		const data = await fetch('http://localhost:8085/products/', {
				method: 'GET',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify()
			})
			.then((res) => {
				console.log(res)
				displayProducts(res)
				return res;
			})
			.catch((error) => console.error("FETCH ERROR:", error));

		function displayProducts(data) {

			// TODO: Display all products
			
			// Koden nedan är ett förslag... 

			/* 
			const product = data.product;
			console.log(data);
			const productDiv = document.getElementById("product"); 
			const heading = document.createElement("h1");
			heading.innerHTML = product;
			productDiv.appendChild(heading);
			

			console.log("Length: " + data.length);

			const list = jQuery('#products');
			for (var i = 0; data.length; i++) {
				const html = '<h1 id="product_' + i + '">' + data[i]['name'] + '</li>';
				list.append(html);
			}
			*/
		}   
	}
</script>

<!-- Home -->
<div class="bg-green-50">
	<div class="flex items-center justify-center flex-col h-[80vh] gap-10">
		<h1 class="text-4xl font-bold">Welcome to Reshoprio</h1>
		<h2 class="text-2xl">Reuse. Shop. Prioritize.</h2>
		<button on:click={getProducts} class="bg-black px-5 py-2 text-white rounded-sm hover:bg-gray-700"><a class="" href="/product">Explore</a></button>
	</div>
</div>

<!-- Dashboard -->
<div class="bg-cyan-100 p-10">
	<h1 class="font-bold text-xl">Dashboard</h1>

	<div class="grid grid-cols-[200px_minmax(900px,_1fr)_100px]">
		<div class="bg-teal-300 p-4 w-48 rounded grid-cols-1">

			<div class="">
				<a class="bg-teal-200 p-2 rounded" href="#">Overview</a>
			</div>

			<br>

			<div class="">
				<a class="bg-teal-200 p-2 rounded" href="#">Orders</a>
			</div>

			<br>

			<div class="">
				<a class="bg-teal-200 p-2 rounded" href="#">Users</a>
			</div>

			<br>

			<div class="">
				<a class="bg-teal-200 p-2 rounded" href="#">Inventory</a>
			</div>

			<br>

			<div class="">
				<a class="bg-teal-200 p-2 rounded" href="#">Settings</a>
			</div>

		</div>

		<div class="bg-teal-50 p-4 rounded w-auto h-96">
			<h1>Welcome to dashboard!</h1>
		</div>
	  </div>

</div>