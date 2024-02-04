;;; Sierra Script 1.0 - (do not remove this comment)
(script# 919)
(include sci.sh)
(use PolyPath)


(class PApproach of PolyPath
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
		distance 20
		targetX 0
		targetY 0
	)
	
	(method (init theClient theDistance)
		(if (>= argc 1)
			(= client theClient)
			(if (>= argc 2)
				(if (IsObject [theDistance 0])
					(= targetX ([theDistance 0] x?))
					(= targetY ([theDistance 0] y?))
					(if (>= argc 3)
						(= distance [theDistance 1])
						(if (>= argc 4) (= caller [theDistance 2]))
					)
				else
					(= targetX [theDistance 0])
					(= targetY [theDistance 1])
					(if (>= argc 4)
						(= distance [theDistance 2])
						(if (>= argc 5) (= caller [theDistance 3]))
					)
				)
			)
			(super init: client targetX targetY caller)
		else
			(super init:)
		)
	)
	
	(method (onTarget)
		(return
			(<=
				(GetDistance (client x?) (client y?) targetX targetY)
				distance
			)
		)
	)
)
