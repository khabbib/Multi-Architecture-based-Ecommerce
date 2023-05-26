<script>
	import Search from '../../components/search.svelte';
</script>

<div class="bg-green-50 p-2">
	<Search />

	<div class="grid grid-cols-3 gap-3 m-4">
		<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
			<h2 class="font-bold">Product 1</h2>
			<h3>Seller: Bob Davis</h3>
			<img src="./imgs/product-sample.png" alt="" />
			<button class="bg-blue-100 shadow m-1 p-2 rounded rounded-sm">Details</button>
		</div>

		<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
			<h2 class="font-bold">Product 2</h2>
			<h3>Seller: Santa Claus</h3>
			<img src="./imgs/product-sample.png" alt="" />
			<button class="bg-blue-100 shadow m-1 p-2 rounded">Details</button>
		</div>

		<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
			<h2 class="font-bold">Product 3</h2>
			<h3>Seller: Emily Johnsson</h3>
			<img src="./imgs/product-sample.png" alt="" />
			<button class="bg-blue-100 shadow m-1 p-2 rounded">Details</button>
		</div>

		<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
			<h2 class="font-bold">Product 4</h2>
			<h3>Seller: Eva Jacksson</h3>
			<img src="./imgs/product-sample.png" alt="" />
			<button class="bg-blue-100 shadow m-1 p-2 rounded">Details</button>
		</div>

		<div class="bg-blue-200 p-4 m-2 shadow rounded text-center">
			<h2 class="font-bold">Product 5</h2>
			<h3>Seller: Alice Peterson</h3>
			<img src="./imgs/product-sample.png" alt="" />
			<button class="bg-blue-100 shadow m-1 p-2 rounded">Details</button>
		</div>
	</div>
</div>
