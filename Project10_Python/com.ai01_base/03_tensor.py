import tensorflow as tf

# placeholder : 그래프를 실행하는 시점에 데이터를 입력받음
node1 = tf.placeholder(dtype=tf.float32)
node2 = tf.placeholder(dtype=tf.float32)
node3 = node1 + node2

sess = tf.Session()

# 실행
print(sess.run(node3, feed_dict={node1:[10, 20, 30], node2: [40, 50, 60]}))
