<script>
	import jQuery from 'jquery'; // kör 'npm install jquery' i cmd
	import { getAllProducts } from '../events/util.js';
</script>

<!-- Home -->
<div class="bg-green-50">
	<div class="flex items-center justify-center flex-col h-[80vh] gap-10" style="overflow: scroll;">
		<h1 class="text-4xl font-bold">Welcome to Reshoprio</h1>
		<h2 class="text-2xl">Reuse. Shop. Prioritize.</h2>
		<button
			on:click={getAllProducts}
			class="bg-black px-5 py-2 text-white rounded-sm hover:bg-gray-700"
			><a class="" href="/product">Explore</a></button
		>
	</div>
</div>
