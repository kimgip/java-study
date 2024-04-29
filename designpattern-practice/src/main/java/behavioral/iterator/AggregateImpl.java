package behavioral.iterator;

public class AggregateImpl<E> implements Aggregate<E> {
	private E[] datas = null;
	
	public AggregateImpl(E[] datas) {
		this.datas = datas;
	}
	
	@Override
	public Iterator<E> createIterator() {
		return new IteratorImp();
	}
	
	class IteratorImp implements Iterator<E> {
		int index = 0;
		
		@Override
		public E next() {
			return index < datas.length ? datas[index++] : null;
		}

		@Override
		public boolean hasNext() {
			return index < datas.length;
		}
		
	}
	
}
