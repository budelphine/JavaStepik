public class RobotConnectionPlay {
	public interface RobotConnection extends AutoCloseable {
		void moveRobotTo(int x, int y);

		@Override
		void close();
	}

	public interface RobotConnectionManager {
		RobotConnection getConnection();
	}

	public class RobotConnectionException extends RuntimeException {

		public RobotConnectionException(String message) {
			super(message);
		}

		public RobotConnectionException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
		for (int i = 0; i < 3; i++) {
			try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
				robotConnection.moveRobotTo(toX, toY);
				// robotConnection.close();
				i = 3;
			} catch (RobotConnectionException e) {
				if (i == 2) {
					throw new RobotConnectionException("Connection Error");
				}
			} catch (Error e) {
				throw new Error("Unexpected Error");
			}

		}
	}
}
