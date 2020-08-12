package com.thoughworks.Universal;

public enum Direction {

	N(0, 1) {

		@Override
		public Direction left() {
			return W;
		}

		@Override
		public Direction right() {
			return E;
		}

	},
	S(0, -1) {

		@Override
		public Direction left() {
			return E;
		}

		@Override
		public Direction right() {
			return W;
		}

	},
	E(1, 0) {

		@Override
		public Direction left() {
			return N;
		}

		@Override
		public Direction right() {
			return S;
		}

	},
	W(-1, 0) {

		@Override
		public Direction left() {
			return S;
		}

		@Override
		public Direction right() {
			return N;
		}

	};

	public abstract Direction left();

	public abstract Direction right();

	int StepSizeOnXAxis;
	int StepSizeOnYAxis;

	Direction(int xC, int yC) {
		this.StepSizeOnXAxis = xC;
		this.StepSizeOnYAxis = yC;
	}

	public int getStepSizeOnXAxis() {
		return StepSizeOnXAxis;
	}

	public int getStepSizeOnYAxis() {
		return StepSizeOnYAxis;
	}

}
