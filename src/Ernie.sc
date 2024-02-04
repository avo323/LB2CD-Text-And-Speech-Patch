;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1893)
(include sci.sh)
(use Main)
(use Blink)
(use View)

(public
	Ernie 23
)

(instance Ernie of Talker
	(properties
		x 5
		y 5
		view 1893
		loop 3
		talkWidth 150
		back 15
		textX 120
		textY 12
	)
	
	(method (init)
		(= font gFont)
		(super init: ernieBust ernieEyes ernieMouth &rest)
	)
)

(instance ernieBust of Prop
	(properties
		view 1893
		loop 1
	)
)

(instance ernieEyes of Prop
	(properties
		nsTop 31
		nsLeft 25
		view 1893
		loop 2
	)
)

(instance ernieMouth of Prop
	(properties
		nsTop 44
		nsLeft 26
		view 1893
	)
)
