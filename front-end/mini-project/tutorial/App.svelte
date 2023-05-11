<div>
    <h1>{content}!</h1>
</div>

<!-- Component (another file) -->
<Component />

<div>
    <h1>Hahahah!</h1>
</div>

{count}
<button on:click={increment}> Click me </button>

<!-- Every style ONLY styles to it's own file --->
<style>
	/* :global() and -global- makes the style be available on other components! */
	:global(h1) {
		color: rebeccapurple;
		/*animation: zoom 5s infinite;*/
	}
	@keyframes -global- zoom {
		0%, 100% {transform: scale(2)}
		50% {transform: scale(0.5)}
	}
</style>

<!-- Every script ONLY scripts to it's own file --->
<script>
	let content = 'Hello world';
	import Component from './Component.svelte';

	let count = 0;

	function increment() {
		count++;
	}
</script>

<!-- tutorial from: https://www.youtube.com/watch?v=UGBJHYpHPvA -->